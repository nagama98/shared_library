@Library("https://github.com/nagama98/shared_library.git") _

pipeline{
    agent any{
        stages{
            stage("first stage "){
                steps{
                    script{
                        shared_library()
                    }
                }
            }
        }

    }
}
