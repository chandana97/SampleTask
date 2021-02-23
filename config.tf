provider "aws" {
  region     = "us-east-1"
}

resource "aws_instance" "instance1" {
  ami           = "ami-07f5c641c23596eb9"
  instance_type = "t2.micro"
}