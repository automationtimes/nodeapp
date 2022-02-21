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
job('job-1') {
  steps {
    shell('echo "This is job-1"')
  }
}


