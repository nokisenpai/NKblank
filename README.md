# NKblank

A blank plugin to create a new plugin under the NK standard

## Create a new plugin based on NKblank

1. Clone NKblank repository `git clone <url>`
2. Rename the project folder as you want
3. Delete the .git folder in project
4. Open the project with IntelliJ
5. Go to `File > Project Structure... > Modules` and rename NKblank module as you want
6. Open the pom.xml and rename the `artifactId` and `name` as you want
7. Rename NKblank class with the same name in pom.xml
8. Rename NKblank package with the same name in pom.xml
9. Create a new repository in git
10. In IntelliJ run `git init`
11. Then `git add .`
12. Then `git commit -m “Initial commit”`
13. Then `git remote add origin <your_git_repo_url>`
14. Then `git push -u origin master`