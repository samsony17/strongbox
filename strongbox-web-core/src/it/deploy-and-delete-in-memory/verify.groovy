import org.apache.maven.artifact.Artifact
import org.carlspring.maven.commons.util.ArtifactUtils
import org.carlspring.strongbox.client.ArtifactClient

try
{
    Artifact artifact = ArtifactUtils.getArtifactFromGAV("org.carlspring.maven:test-project:1.0");

    ArtifactClient client = new ArtifactClient();
    client.deleteArtifact(artifact, "storage0", "releases-in-memory");

    return !client.artifactExists(artifact, "storage0", "releases-in-memory");
}
catch( Throwable t )
{
    System.out.println(" *[ Check failed ]* ");
    t.printStackTrace();
    return false;
}

return true;