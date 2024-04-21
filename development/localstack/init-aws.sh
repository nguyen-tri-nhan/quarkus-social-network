#!/usr/bin/env bash

# This bash file supposes the localstack is launched in local computer from the
# setup instruction in the README.md file at the repo root dir

set -euo pipefail

LOCALSTACK_HOST=localhost
AWS_REGION=us-east-1
AWS_ACCOUNT_ID="000000000000"

awslocal() {
  AWS_ACCESS_KEY_ID=test AWS_SECRET_ACCESS_KEY=test AWS_DEFAULT_REGION=${AWS_REGION} aws --endpoint-url=http://${LOCALSTACK_HOST:-localhost}:4566 --region ${AWS_REGION} "$@"
}

create_s3_bucket() {
  local BUCKET_NAME_TO_CREATE=$1
  awslocal s3 mb s3://"${BUCKET_NAME_TO_CREATE}" 
  awslocal s3api put-bucket-cors --bucket "${BUCKET_NAME_TO_CREATE}" --cors-configuration '{"CORSRules": [{"AllowedHeaders": ["*"],"AllowedMethods": ["GET"],"AllowedOrigins": ["*"]}]}'
}

create_s3_bucket "images"

#This command must always be the last one in the script in order to mark the setup is completed
echo "SETUP COMPLETED"
