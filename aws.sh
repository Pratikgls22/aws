#!/bin/bash

# deploy.sh

# Update and install necessary packages
sudo apt-get update
sudo apt-get install -y docker.io docker-compose git

# Clone the repository from GitHub
REPO_URL="https://github.com/Pratikgls22/aws"
CLONE_DIR="/home/ubuntu/learning-EC2"

if [ -d "$CLONE_DIR" ]; then
  echo "Repository already exists. Pulling latest changes..."
  cd "$CLONE_DIR"
  git pull origin aws
else
  echo "Cloning repository..."
  git clone "$REPO_URL" "$CLONE_DIR"
  cd "$CLONE_DIR"
fi

# Build and run the Docker containers
echo "Starting Docker containers..."
sudo docker-compose up --build -d

echo "Deployment complete!"