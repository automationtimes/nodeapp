@Library('shared-library') _

pipeline {
    agent {label 'awsmachine'}  

    stages{
        stage("node js app build"){
            steps
            {  
            sh 'npm install' 
            }
        }
        //   stage("App Deploy"){
        //     steps
        //     {  sh 'whoami'
               
             
        //        sh 'scp -r  /home/ec2-user/workspace/webapplication/* ubuntu@10.0.1.9:/var/www/html/'
        //        sh 'ssh  -o StrictHostKeyChecking=no ubuntu@10.0.1.9 "cd /var/www/html/ && pm2 start index.js -f && NODE_ENV=dev pm2 restart 0 --update-env"'
        //     }
        //  }
    stage('SSH into the server') {
        steps {
            script {
                def remote = [:]
                remote.name = 'ubuntu'
                remote.host = '18.116.25.119'
                remote.user = 'ubuntu'
                remote.password = 'ubuntu'
                remote.allowAnyHosts = true
                writeFile file: 'abc.sh', text: 'ls -lrt'
                sshPut remote: remote, from: 'abc.sh', into: '/var/www/html/'
        }
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
