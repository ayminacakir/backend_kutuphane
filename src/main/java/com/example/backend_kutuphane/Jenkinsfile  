pipeline {
    agent any  // Herhangi bir ajan üzerinde çalıştırılacak

    environment {
        MAVEN_HOME = tool name: 'Maven', type: 'ToolType'  // Maven aracının yolu
    }

    stages {
        // 1. Stage: Kaynak kodunu çekme (GitHub'dan)
        stage('Checkout') {
            steps {
                checkout scm  // Kaynak kodu almak
            }
        }

        // 2. Stage: Derleme (Maven ile)
        stage('Build') {
            steps {
                script {
                    // Maven komutuyla projeyi derle
                    sh "'${MAVEN_HOME}/bin/mvn' clean install"
                }
            }
        }

        // 3. Stage: Test
        stage('Test') {
            steps {
                script {
                    // Maven komutuyla testleri çalıştır
                    sh "'${MAVEN_HOME}/bin/mvn' test"
                }
            }
        }

        // 4. Stage: Dağıtım (Örneğin prod ortamına)
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying to production environment...'
                    // Dağıtım komutları burada yer alabilir
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }

        failure {
            echo 'Pipeline failed!'
        }
    }
}
