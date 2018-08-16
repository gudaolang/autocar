/**
 * projectName: base
 * Created by lee on 2018/8/10 22:42
 */
pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'building'
                sh 'make'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
        stage('test') {
            steps {
                echo 'testing'
                sh 'make check || true'
                junit '**/target/*.xml'
            }
        }
        stage('deploy') {
            when {
                expression {
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
            steps {
                echo 'deploying'
            }
        }
    }
}