# file-repo-actions-with-java

File repository actions with java.

# 1 SVN

Using SVNKit library <https://svnkit.com/index.html>.

Maven-Dependency:

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

Checkout all repository contents/files. See [SVNActions.testCheckout()](https://github.com/Vitmonk/file-repo-actions-with-java/blob/master/src/main/java/com/github/vitmonk/filerepo/SVNActions.java).

# 2 GIT

Using JGit library <https://git-scm.com/book/be/v2/Embedding-Git-in-your-Applications-JGit>.

_Notice:_ This category covers only stuff i needed. If you need more check a wonderful repo <https://github.com/centic9/jgit-cookbook> created by **centic9**.

Maven-Dependency:

	<dependency>
		<groupId>org.eclipse.jgit</groupId>
		<artifactId>org.eclipse.jgit</artifactId>
		<version>4.6.0.201612231935-r</version>
	</dependency>
	
# 2.1 Clone

Clone all repository contents/files. See [GITActions.testClone()](https://github.com/Vitmonk/file-repo-actions-with-java/blob/master/src/main/java/com/github/vitmonk/filerepo/GITActions.java).