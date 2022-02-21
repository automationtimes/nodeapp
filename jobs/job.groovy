// pipelineJob('DSL') {

//     def repo = ' https://github.com/automationtimes/nodeapp'
   
//     triggers {
//         scm('* * * * *')
//     }
    
//     definition {
//         cpsScm {
//           scm {
//             git(repo, 'master', { node -> node / 'extensions' << '' } )
//             }
//         }
//     }
    
// }
job('Hello World') {
  steps {
    shell('echo "Hello World!"')
  }
}


