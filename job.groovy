jobs:
    job('testJob1') {
        scm {
            git('https://github.com/automationtimes/nodeapp')
        }
        branch('*/master')
        triggers {
            scm('* * * * *')
        }
    }
    job('build') {
        steps {
            sh 'npm install'
        }
    }
