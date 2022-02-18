jobs:
  - script: >
      job('testJob1') {
          scm {
              git('https://github.com/automationtimes/nodeapp')
          }
          branch('*/master')
          triggers {
              scm('* * * * *')
          }
          steps {
             sh 'npm install'
          }
      }