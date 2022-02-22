pipelineJob('DSL') {

    def repo = ' https://github.com/automationtimes/nodeapp'
    
    definition {
        cpsScm {
          scm {
            git(repo, 'master', { node -> node / 'extensions' << '' } )
            }
        }
    }
    steps {
       shell('npm install')
    }
    
}



