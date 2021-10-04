sam build
sam package --s3-bucket s3-simple-lambda --output-template-file .aws-sam/out.yaml
sam deploy --template-file .aws-sam/out.yaml --capabilities CAPABILITY_IAM --stack-name LambdaSsmParameter