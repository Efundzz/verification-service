## Steps to configure aws in local (first time profile setup):
#### Sample Setting.xml
    <?xml version="1.0" encoding="UTF-8"?>
    <settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 http://maven.apache.org/xsd/settings-1.2.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.2.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
        <servers>
            <server>
                <id>efundzz-dbconnect</id>
                <username>aws</username>
                <password>${env.EFUNDZZ_CODEARTIFACT_AUTH_TOKEN_EU_WEST1}</password>
            </server>
        </servers>
    </settings>

#### To configure aws in your machine:
```bash 
aws configure sso --profile efundzz
```

#### To check if you are able to download the pakage from codeartifact:
```bash
aws codeartifact get-package-version-asset --domain efundzz --domain-owner 247423452789 --repository dbconnect \
--format maven --namespace com.efundzz --package db-connect --package-version 0.0.1-SNAPSHOT \
--asset db-connect-0.0.1-20230928.225709-4.jar db-connect-0.0.1-20230928.225709-4.jar
```

------------------------------------------------------------------------------------------

## Steps to pull latest dbconnect into code
#### To login to sso:
```bash
aws sso login --profile efundzz
```

```bash
export EFUNDZZ_CODEARTIFACT_AUTH_TOKEN_EU_WEST1=$(aws codeartifact get-authorization-token --domain efundzz --domain-owner 247423452789 --profile efundzz --region eu-west-1 --query authorizationToken --output text)
```

#### To check if the export is done successfully, the below command should not return empty
```bash
echo $EFUNDZZ_CODEARTIFACT_AUTH_TOKEN_EU_WEST1
```

#### To compile the code
```bash
mvn compile -U
```

------------------------------------------------------------------------------------------

## Pushing the code to ECR
#### To login to ecr [For uploading]
```bash
aws ecr get-login-password --region eu-west-1 --profile efundzz | docker login --username AWS --password-stdin 247423452789.dkr.ecr.eu-west-1.amazonaws.com
```

#### To install latest dependencies:
```bash
mvn clean install
```

#### To increment the application version:
```bash
mvn versions:set -DnewVersion=0.0.2-SNAPSHOT
```

#### To build the image, start docker and then run the below command. The image with the version set would be created.
```bash
mvn spring-boot:build-image
```

#### To push the docker image:
```bash
docker push 247423452789.dkr.ecr.eu-west-1.amazonaws.com/verification-service:0.0.2-SNAPSHOT
```