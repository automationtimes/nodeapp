pipeline {
    agent any
    
    stages{
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
}
def notifySlack(String buildStatus = 'STARTED') {
    // Build status of null means success.
    buildStatus = buildStatus ?: 'SUCCESS'

    def color

    if (buildStatus == 'STARTED') {
        color = '#D4DADF'
    } else if (buildStatus == 'SUCCESS') {
        color = '#BDFFC3'
    } else if (buildStatus == 'UNSTABLE') {
        color = '#FFFE89'
    } else {
        color = '#FF9FA1'
    }

    def msg = "${buildStatus}: `${env.JOB_NAME}` #${env.BUILD_NUMBER}:\n${env.BUILD_URL}"

    slackSend(color: color, message: msg)
}

node {
    try {
        notifySlack()

        // Existing build steps.
    } catch (e) {
        currentBuild.result = 'FAILURE'
        throw e
    } finally {
        notifySlack(currentBuild.result)
    }
}
