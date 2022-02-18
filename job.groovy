pipelineJob('DSL_Demo') {

    def repo = ' https://github.com/automationtimes/nodeapp'
   
    triggers {
        scm('* * * * *')
    }
    
    definition {
        cpsScm {
          scm {
            git(repo, 'master', { node -> node / 'extensions' << '' } )
            }
        }
    }
}


