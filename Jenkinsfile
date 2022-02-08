pipipeline {
    agent any
    
    stages{
        stage("checkout from git")
        {
            steps
            {   
                git credentialsId: '8151c8f4-8725-44e3-ae3f-/var/lib/jenkins/workspace41f5ac651f55', url: 'https://github.com/automationtimes/nodeapp.git'
            }
        }
        stage("node js app build")
        {
            steps
            {   
          
               sh 'npm install'
              
            }
        }
          stage("artifacts store")
          {
           
            steps
            {  
               sh 'scp -r /var/lib/jenkins/workspace/nodeapplication/* root@10.0.0.159:/var/www/html/'
               sh 'ssh  -o StrictHostKeyChecking=no ubuntu@10.0.0.159 "pwd && cd /var/www/html/ && pm2 start index.js -f && NODE_ENV=dev pm2 restart 0 --update-env"'
      
              

                
            }
         }
    }

node {
    try {
        notifyBuild('STARTED')

        stage('checkout from git') {
            echo 'do checkout stuff'
        }

        stage('node js app build') {
            echo 'Application Build'
        }

        stage('Application Deploy to Server') {
            echo 'Application Deploy to Server'
            
        }

  } catch (e) {
    // If there was an exception thrown, the build failed
    currentBuild.result = "FAILED"
    throw e
  } finally {
    // Success or failure, always send notifications
    notifyBuild(currentBuild.result)
  }
}

def notifyBuild(String buildStatus = 'STARTED') {
  // build status of null means successful
  buildStatus =  buildStatus ?: 'SUCCESSFUL'

  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
  def summary = "${subject} (${env.BUILD_URL})"

  // Override default values based on build status
  if (buildStatus == 'STARTED') {
    color = 'YELLOW'
    colorCode = '#FFFF00'
  } else if (buildStatus == 'SUCCESSFUL') {
    color = 'GREEN'
    colorCode = '#00FF00'
  } else {
    color = 'RED'
    colorCode = '#FF0000'
  }

  // Send notifications
  slackSend (color: colorCode, message: summary)
}
}
