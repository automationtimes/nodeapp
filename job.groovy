job('testJob1') {
    scm {
        git('https://github.com/automationtimes/nodeapp'){  node -> 
      // is hudson.plugins.git.GitSCM            
  node / gitConfigName('zohaib')            
  node / gitConfigEmail('zohaib@gmail.com')        
    }    
}
triggers {          
  scm('* * * * *')    
}    
wrappers {        
nodejs('nodejs') 
steps {        
shell("npm install")    
  }
}
