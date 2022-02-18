job('DSL example') {    
scm {        
git('https://github.com/automationtimes/nodeapp') {  node -> 
      // is hudson.plugins.git.GitSCM            
  node / gitConfigName('zohaib')            
  node / gitConfigEmail('zohaib@gmail.com')        
    }    
}
triggers {          
  scm('H/5 * * * *')    
}    
wrappers {        
nodejs('nodejs') 
// this is the name of the NodeJS installation in                                                // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name    }    
steps {        
shell("npm install")    
  }
}


