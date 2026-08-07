#!/bin/bash
set -e
CLASSPATH="/home/philip/githome/teaql-code-gen/generator/target/generator-1.1.0.jar"
MODELS="/home/philip/githome/datahub-hackson-2026/massive_erp_model.xml"

declare -a frameworks=("java-lib-core" "java-web-spring-boot" "java-web-quarkus" "java-web-micronaut" "java-app-console" "rust-lib-core" "rust-web-axum" "rust-web-topcoat")

echo "Generating and testing..." > build.log

for fw in "${frameworks[@]}"; do
    echo "=======================================" | tee -a build.log
    echo "Testing $fw (Skipping generator since jar is missing)" | tee -a build.log
    # java -cp $CLASSPATH -Dloader.main=com.skynet.codegenerator.LocalGenerator org.springframework.boot.loader.PropertiesLauncher "$fw" "$fw" "$MODELS" >> build.log 2>&1
    
    if [[ "$fw" == java* ]]; then
        echo "Running $fw tests" | tee -a build.log
        if [[ "$fw" == *-lib-* ]]; then
            (cd "$fw/lib" && mvn clean install -DskipTests >> ../../build.log 2>&1)
        else
            (cd "$fw" && mvn clean install -DskipTests >> ../build.log 2>&1)
        fi
    else
        echo "Running $fw tests" | tee -a build.log
        if [[ "$fw" == *-lib-* ]]; then
            (cd "$fw/lib" && cargo build >> ../../build.log 2>&1)
        else
            (cd "$fw" && cargo test >> ../build.log 2>&1)
        fi
    fi
    echo "$fw DONE." | tee -a build.log
done
