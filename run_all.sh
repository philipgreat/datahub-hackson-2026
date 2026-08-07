#!/bin/bash
set -e

# The generator jar is intentionally skipped since it's not present in this docker image.
# We will use the already-generated domain code.

declare -a frameworks=("java-lib-core" "java-web-spring-boot" "java-web-quarkus" "java-web-micronaut" "rust-lib-core" "rust-app-console" "rust-web-axum" "rust-web-topcoat")

LOG_DIR="examples/payment/run/build-and-test"
mkdir -p "$LOG_DIR"
BUILD_LOG="$LOG_DIR/run_all.log"

echo "Generating and testing..." > "$BUILD_LOG"

for fw in "${frameworks[@]}"; do
    echo "=======================================" | tee -a "$BUILD_LOG"
    echo "Testing $fw (Skipping generator since jar is missing)" | tee -a "$BUILD_LOG"
    
    if [[ "$fw" == java* ]]; then
        echo "Running $fw tests" | tee -a "$BUILD_LOG"
        if [ -f "$fw/pom.xml" ]; then
            (cd "$fw" && mvn clean test >> "../$BUILD_LOG" 2>&1)
        elif [ -f "$fw/lib/pom.xml" ]; then
            (cd "$fw/lib" && mvn clean test >> "../../$BUILD_LOG" 2>&1)
        else
            echo "Warning: No pom.xml found for $fw" | tee -a "$BUILD_LOG"
        fi
    else
        echo "Running $fw tests" | tee -a "$BUILD_LOG"
        if [ -f "$fw/Cargo.toml" ]; then
            (cd "$fw" && cargo test >> "../$BUILD_LOG" 2>&1)
        elif [ -f "$fw/lib/Cargo.toml" ]; then
            (cd "$fw/lib" && cargo test >> "../../$BUILD_LOG" 2>&1)
        else
            echo "Warning: No Cargo.toml found for $fw" | tee -a "$BUILD_LOG"
        fi
    fi
    echo "$fw DONE." | tee -a "$BUILD_LOG"
done

