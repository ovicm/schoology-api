import org.junit.jupiter.api.Test;

import net.rvanasa.schoology.SchoologyNode;
import net.rvanasa.schoology.SchoologyRequestHandler;
import net.rvanasa.schoology.SchoologyResponseBody;
import net.rvanasa.schoology.impl.BasicOAuthResourceLocator;
import net.rvanasa.schoology.impl.OAuthSchoologyRequestHandler;

public class OauthTest {
    @Test
    public void testOauthLogin() {
        SchoologyRequestHandler schoology = new OAuthSchoologyRequestHandler(new BasicOAuthResourceLocator(""), "5a596736a23ff5a2d9798b348dd54e7d05a0af681", "5365261c99baf70fff42e346a77c8905");

        SchoologyResponseBody response = schoology.get("sections/123456789").requireSuccess().getBody();

        System.out.println(response.getRawData()); // JSON string

        SchoologyNode node = response.parse();
        System.out.println(node.get("JSON_KEY").get(1).asString());
    }
}
