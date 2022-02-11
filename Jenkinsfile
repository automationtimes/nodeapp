@Library('shared-library') _

pipeline {
    agent {label 'awsmachine'}  

    stages{
        stage("node js app build"){
            steps
            {  
               
             sh '''yum -y install epel-release
amazon-linux-extras install epel
yum repolist
yum install dpkg-devel dpkg-dev
REQUIRED_PKG="nodejs"
PKG_OK=$(dpkg-query -W --showformat=\\\'${Status}\\\\n\\\' $REQUIRED_PKG|grep "install ok installed")
echo Checking for $REQUIRED_PKG: $PKG_OK
if [ "" = "$PKG_OK" ]; then
echo "No $REQUIRED_PKG. Setting up $REQUIRED_PKG."
sudo yum -y install curl
curl -sL https://rpm.nodesource.com/setup_12.x | sudo bash -
sudo yum install $REQUIRED_PKG -y
node --version
fi'''  
            sh 'npm install' 
            }
        }
          stage("App Deploy"){
            steps
            {  sh 'whoami'
               sh 'scp -r /home/ec2-user/workspace/webapplication/* ubuntu@10.0.2.212:/var/www/html/'
               sh 'ssh  -o StrictHostKeyChecking=no ubuntu@10.0.2.212 "cd /var/www/html/ && pm2 start index.js -f && NODE_ENV=dev pm2 restart 0 --update-env"'
            }
         }

    }
      post {
     always {
         script {
        slack.slack_code()
         }
          cleanWs()
     }
  }

}
