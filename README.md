Please read the following words if it's your first time here~
===
This repository is created for the group project of CAN301 (from Xi'an Jiaotong-Liverpool University) during the first semester of 2023-24 academic year. The name of our group is High Score Please!<br>
Anyone in our group is free to update the files unmaliciously.<br>

Pleaseeeeeeeeeeeeeeee first PULL the whole repo using `'git pull origin master'` and then modify your code locally in case of unsynchronization.
---

The basic operations are listed below (The first 14 items are from Soon Phei Tin):
---
Local vs. Remote Repository
Creating, managing, and synchronizing repository
1.Create a new local repository using `git init`
2.Check the status of the files in the repository using `git status`
3.Track the files using `git add`
a.Use `git add .` to track all untracked files
4.Commit the tracked files to the repository using `git commit –m “commit message”`
5.Exercise: -
a.Add 3.txt to the repository. Check the status
b.Modify 2.txt. Check the status
c.Commit 2.tx and 3.txt to the repository.
6.Get your GitLab account if you don’t have one. Create one Remote Repository
7.Add a remote repository to your local project using `git remote add origin “<repository URL>”`
8.Push the local repository to the remote repository using `git push origin master`
9.Programmer 2 Cloning Repository: Refer to the earlier document on LM
10.Programmer 1 add d.txt and edit the file. Commit the change, and push (Step 8) the change to the remote repository.
11.Programmer 2 synchronize the code using `git pull origin master`
12.Check the details of your every commit using `git log`
13.At any point of time when you need to revert your code, use `git revert <commit-id>`
a.The revert is done only for local repository
b.You need to do git push in order for the remote to take effect.
c.Programmer 2 will not see the change unless (s)he did git pull
14.You can compare the content of your commits using `git diff <commit ID 1> <commit ID 2>`
15.You can create a new branch using git `branch branch_name`
