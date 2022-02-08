pipipeline {
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
