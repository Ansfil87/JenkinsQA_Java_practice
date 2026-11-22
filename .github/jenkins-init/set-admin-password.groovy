// Runs once at Jenkins startup in CI (copied into $JENKINS_HOME/init.groovy.d).
// Sets the admin password from the repository secrets,
// so the CI does not depend on the password stored in the Jenkins backup.
import hudson.security.HudsonPrivateSecurityRealm
import jenkins.model.Jenkins

def username = System.getenv('JENKINS_ADMIN_USERNAME') ?: 'admin'
def password = System.getenv('JENKINS_ADMIN_PASSWORD')

def realm = Jenkins.get().getSecurityRealm()

if (password && realm instanceof HudsonPrivateSecurityRealm) {
    realm.createAccount(username, password)
    println "[init] Password for user '${username}' has been set"
} else {
    println "[init] Password was not changed (no JENKINS_ADMIN_PASSWORD or unsupported security realm)"
}
