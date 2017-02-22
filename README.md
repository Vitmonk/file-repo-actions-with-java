# file-repo-actions-with-java

File repository actions with java.

# 1 SVN

Using SVNKit Library https://svnkit.com/index.html.

Maven-Dependecy:

	<dependency>
		<groupId>org.tmatesoft.svnkit</groupId>
		<artifactId>svnkit</artifactId>
		<version>1.8.15</version>
	</dependency>
	
Repository:

	<repository>
		<id>tmatesoft-releases</id>
		<url>https://maven.tmatesoft.com/content/repositories/releases/</url>
	</repository>

## 1.1 Checkout

Checkout all repository contents/files. See `SVNActions.testCheckout()`.
