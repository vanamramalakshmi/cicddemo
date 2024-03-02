pipeline {
    agent any

    tools {

        maven "maven"
    }

    stages {
        stage('SCM checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/vanamramalakshmi/cicddemo.git']])
            }
        }

        stage('Build Process'){
            steps{
                bat "mvn clean install"

            }
        }

        stage('Deploy to container'){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-pwd', path: '', url: 'http://localhost:9090/')], contextPath: 'jenkinscicd', war: '**/*.war'
            }


        }
    }
       post{
        always{
            emailext attachLog: true,
            body: ''' <html>
    <body>
        <p>Build Status: ${BUILD_STATUS}</p>
        <p>Build Number: ${BUILD_NUMBER}</p>
        <p>Check the <a href="${BUILD_URL}">console output</a>.</p>
    </body>
</html>''', mimeType: 'text/html', replyTo: 'vanam.ramalakshmi06@gmail.com', subject: 'Pipeline Status : ${BUILD_NUMBER}', to: 'vanam.ramalakshmi06@gmail.com'

        }
    }
}
