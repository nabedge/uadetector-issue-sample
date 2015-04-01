package com.example;

import static org.junit.Assert.*;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.VersionNumber;
import net.sf.uadetector.service.UADetectorServiceFactory;

import org.junit.Test;

public class versionNumberCompareTest {

	private final String uaString = "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; InfoPath.1";

	@Test
	public void equalsTestA() {
		UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
		ReadableUserAgent rua = parser.parse(uaString);
		VersionNumber versionNumber = new VersionNumber("8");
		assertEquals(0, rua.getVersionNumber().compareTo(versionNumber));
	}

	@Test
	public void equalsTestB() {
		UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
		ReadableUserAgent rua = parser.parse(uaString);
		VersionNumber versionNumber = new VersionNumber("8","0"); // MSIE 8.0 と正確に比較するには majer,minor両方を明示的に指定する必要がある!
		assertEquals(0, rua.getVersionNumber().compareTo(versionNumber));
	}
}
