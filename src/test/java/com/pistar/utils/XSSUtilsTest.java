package com.pistar.utils;

import org.junit.Assert;
import org.junit.Test;

public class XSSUtilsTest {

    @Test
    public void stripXSS() throws Exception {

        executeStripXSS("Um texto qualquer, sem conteudo malicioso");
        executeStripXSS("{\"actors\":[{\"id\":\"f4f22e75-eb35-4ec0-80b4-ace4a45feaf0\",\"text\":\"a1\",\"type\":\"istar.Actor\",\"x\":49,\"y\":49,\"nodes\":[{\"id\":\"da7222a8-dc4b-4f38-9032-d45b1eff9b65\",\"text\":\"g1\",\"type\":\"istar.Goal\",\"x\":200,\"y\":88},{\"id\":\"79ad4591-2248-4a93-96c4-15feabe39730\",\"text\":\"g2\",\"type\":\"istar.Goal\",\"x\":110,\"y\":170},{\"id\":\"8c45a51f-f250-4334-915d-6120d50c6a5d\",\"text\":\"g3\",\"type\":\"istar.Goal\",\"x\":267,\"y\":170},{\"id\":\"28a8ba91-f960-4f14-932b-b1decca81cac\",\"text\":\"q1\",\"type\":\"istar.Quality\",\"x\":510,\"y\":250},{\"id\":\"9c24cd66-2fd9-4df0-bb24-a6fd60f54fb0\",\"text\":\"q2\",\"type\":\"istar.Quality\",\"x\":440,\"y\":100},{\"id\":\"ab57f578-1b33-4b58-9e99-e2549f6845b2\",\"text\":\"t1\",\"type\":\"istar.Task\",\"x\":150,\"y\":270},{\"id\":\"821fe9dc-781a-410d-9c3d-d0baf315afd3\",\"text\":\"t2\",\"type\":\"istar.Task\",\"x\":315,\"y\":260},{\"id\":\"78eeda46-1f3f-4f17-9105-0429a4b189bf\",\"text\":\"r1\",\"type\":\"istar.Resource\",\"x\":336,\"y\":340},{\"id\":\"b188d2f4-1d6c-4daf-8bde-623fa37b6ea1\",\"text\":\"r2\",\"type\":\"istar.Resource\",\"x\":560,\"y\":180}]}],\"dependencies\":[],\"links\":[{\"id\":\"15611cb5-41d6-46ad-ba50-b6cc7e861b31\",\"type\":\"istar.AndRefinementLink\",\"source\":\"79ad4591-2248-4a93-96c4-15feabe39730\",\"target\":\"da7222a8-dc4b-4f38-9032-d45b1eff9b65\"},{\"id\":\"d52c401f-001f-4117-b4ae-2c8cfe5c655d\",\"type\":\"istar.AndRefinementLink\",\"source\":\"8c45a51f-f250-4334-915d-6120d50c6a5d\",\"target\":\"da7222a8-dc4b-4f38-9032-d45b1eff9b65\"},{\"id\":\"f36df88d-eb3a-4ecc-a80d-3d2162d637de\",\"type\":\"istar.OrRefinementLink\",\"source\":\"ab57f578-1b33-4b58-9e99-e2549f6845b2\",\"target\":\"8c45a51f-f250-4334-915d-6120d50c6a5d\"},{\"id\":\"0b611008-4db4-47c1-af51-41f85c3db1fd\",\"type\":\"istar.OrRefinementLink\",\"source\":\"821fe9dc-781a-410d-9c3d-d0baf315afd3\",\"target\":\"8c45a51f-f250-4334-915d-6120d50c6a5d\"},{\"id\":\"de76c2ab-150c-4abb-83cc-4b8420738b67\",\"type\":\"istar.NeededByLink\",\"source\":\"78eeda46-1f3f-4f17-9105-0429a4b189bf\",\"target\":\"821fe9dc-781a-410d-9c3d-d0baf315afd3\"},{\"id\":\"2687caa3-7cdc-4816-9fd2-3904fed3b89b\",\"type\":\"istar.ContributionLink\",\"source\":\"78eeda46-1f3f-4f17-9105-0429a4b189bf\",\"target\":\"28a8ba91-f960-4f14-932b-b1decca81cac\",\"label\":\"hurt\"},{\"id\":\"c5dbdc4c-5a2d-443b-a9a3-066add2b1470\",\"type\":\"istar.ContributionLink\",\"source\":\"821fe9dc-781a-410d-9c3d-d0baf315afd3\",\"target\":\"9c24cd66-2fd9-4df0-bb24-a6fd60f54fb0\",\"label\":\"make\"},{\"id\":\"9fd04f96-c486-4ff3-b743-f5367e310913\",\"type\":\"istar.QualificationLink\",\"source\":\"9c24cd66-2fd9-4df0-bb24-a6fd60f54fb0\",\"target\":\"b188d2f4-1d6c-4daf-8bde-623fa37b6ea1\"}],\"tool\":\"pistar.1.0.0\",\"istar\":\"2.0\",\"saveDate\":\"Tue, 04 Jul 2017 03:46:52 GMT\",\"diagram\":{\"width\":2232,\"height\":1172}}");
        executeStripXSS("<SCRIPT>alert(“Cookie”+document.cookie)</SCRIPT>");
        executeStripXSS("<body onload=alert('test1')>");
        executeStripXSS("<b onmouseover=alert('Wufff!')>click me!</b>");
        executeStripXSS("<img src=\"http://url.to.file.which/not.exist\" onerror=alert(document.cookie);>");
        executeStripXSS("<IMG SRC=j&#X41vascript:alert('test2')>\n");
        executeStripXSS("<META HTTP-EQUIV=\"refresh\"\n" +
                "CONTENT=\"0;url=data:text/html;base64,PHNjcmlwdD5hbGVydCgndGVzdDMnKTwvc2NyaXB0Pg\">\n");

    }

    private static void executeStripXSS(String value) {
        System.out.println("\t Antes  - "+value);
        value = XSSUtils.stripXSS(value);
        System.out.println("\t Depois - "+value);
        Assert.assertFalse("O conteúdo "+value+" possui valor malicioso", value.matches(".*\\<[^>]+>.*"));
        System.out.println("--------------------------------");
    }

}