jobs:
  - script: >
      job('testJob1') {
          scm {
              git('https://github.com/automationtimes/nodeapp')
          }
          triggers {
              scm('H/1 * * * *')
          }
          steps {
             sh 'npm install'
          }
      }