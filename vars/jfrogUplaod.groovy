def call() {
sh curl -X PUT -u admin:Admin123 -T ./var/lib/jenkins/workspace/JfrogArtf/target/kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar http://3.142.47.84:8082/artifactory/example-repo-local
  }
