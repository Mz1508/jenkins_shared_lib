echo 'jfrog start...........................'
                    def server = Artifactory.newServer url: registry + "/artifactory", credentialsId: "Jfrog"
                    echo '1'
                    def properties = "buildid=${env.BUILD_ID},commitid=${GIT_COMMIT}";
                    echo '2'
                    def uploadSpec = """{
                        "files": [
                            {
                                "pattern": "target/(*)",
                                "target": "libs-release-local/{1}",
                                "flat": "false",
                                "props": "${properties}",
                                "exclusions": ["*.sha1", "*.md5"]
                            }
                        ]
                    }"""
                    echo '3'
                    def buildInfo = server.upload(uploadSpec)
                    echo '4'
                    buildInfo.env.collect()
                    server.publishBuildInfo(buildInfo)
                    echo '<--------------- Jar Publish Ended --------------->'
