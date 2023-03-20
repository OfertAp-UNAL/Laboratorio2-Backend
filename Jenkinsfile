pipeline{
    agent any

    environment {
        DB_PORT = '8585',
        DB_USER= 'admin',
        DB_PASSWORD= 'admin',
        DB_NAME = 'labs',
        PORT = '7777',
    }

    stages{
        stage( 'clean' ){
            steps{
                sh "mvn clean"
            }
        }
        stage( 'test' ){
            steps{
                sh "mvn test"
            }
        }
        stage( 'package' ){
            steps{
                sh "mvn package"
            }
        }
    }
}