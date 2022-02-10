pipeline {
    agent any
    
    stages{
        stage("node js app build"){
         agent {label 'buildmachine'}
        
            steps
            {   
               sh 'npm install' 
            }
        }
          stage("App Deploy"){
            
            steps
            {  
               sh 'scp -r /home/ubuntu/slave1/workspace/nodejsapp/* root@10.0.2.212:/var/www/html'
               sh 'ssh  -o StrictHostKeyChecking=no root@10.0.2.212 "pwd && cd /var/www/html/ && pm2 start index.js -f && NODE_ENV=dev pm2 restart 0 --update-env"'
            }
         }

    }
//      post {
//     always {
//         script {
//            slackSend(
//                 color: color_slack_msg(),
//                 message: """
//                      *${currentBuild.currentResult}:* Job `${env.JOB_NAME}` build `${env.BUILD_DISPLAY_NAME}`>
//                      More info at: ${env.BUILD_URL}
//                      Time: ${currentBuild.durationString.minus(' and counting')}
//                      """
//              )
//          }
//          cleanWs()
//      }
//  }
}
//  def color_slack_msg() {
//      switch(currentBuild.currentResult) {
//      case "SUCCESS":
//          return "good"
//          break
//      case "FAILURE":
//      case "UNSTABLE":
//          return "danger"
//          break
//      default:
//          return "warning"
//          break
//      }
//  }