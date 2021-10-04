# Usage:
# make        # deploy code in dev instance
# make deploy-dev  # deploy code in dev instance
# make deploy-qa  # deploy code in qa instance
# make deploy-prod  # deploy code in prod instance

.PHONY = deploy

stage=dev
bucket = wonderfl
s3prefix = builds
profile = hbc-common
region = us-east-1
templateFile = template.yaml
capabilities = CAPABILITY_IAM
directory = .aws-sam
generatedTemplateFile = ${directory}/template-generated.yaml


deploy: | $(directory)
	@echo "deploying to $(stage)"
	sam build
	sam package --s3-bucket ${bucket} --s3-prefix ${s3prefix} --output-template-file ${generatedTemplateFile} --region ${region} --profile ${profile}
	sam deploy --template-file ${generatedTemplateFile} --stack-name mp-product-import-$(stage) --capabilities ${capabilities} --profile ${profile}

deploy-dev: stage=dev
deploy-dev: deploy

deploy-qa: stage=qa
deploy-qa: deploy

deploy-prod: stage=prod
deploy-prod: deploy

$(directory):
	@mkdir -p $@