node {
    stage('Checkout') {
        checkout scm
        sh 'chmod +x ./gradlew'
    }

    stage('Build') {
        sh './gradlew build'
    }
    
    stage('Test') {
        sh './gradlew check'
        junit 'build/reports/coverage/report.xml'
        jacoco(execPattern: 'build/jacoco/test.exec')
    }
}
