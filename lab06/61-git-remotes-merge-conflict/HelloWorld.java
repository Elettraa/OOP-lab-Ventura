public final class HelloWorld {

    private static final String AUTHOR = "Danilo Pianini";

    public static void main(final String[] args) {
        System.out.println("This program has been realised by " + AUTHOR);
        System.out.println("This program is running in a PC with " + procNumber() + " logic processors!");
    }

    public static int procNumber() {
        return Runtime.getRuntime().availableProcessors();
    }

}
/*
 * elettra@MioPC:~$ ls
 * eserciziOOPVentura
 * elettra@MioPC:~$ git clone
 * git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git
 * Cloning into 'OOP-git-merge-conflict-test'...
 * remote: Enumerating objects: 12, done.
 * remote: Counting objects: 100% (4/4), done.
 * remote: Compressing objects: 100% (3/3), done.
 * remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8 (from 1)
 * Receiving objects: 100% (12/12), done.
 * Resolving deltas: 100% (2/2), done.
 * elettra@MioPC:~$ cd OOP-git-merge-conflict-test/
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ ls
 * HelloWorld.java
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git status
 * On branch master
 * Your branch is up to date with 'origin/master'.
 * 
 * nothing to commit, working tree clean
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git branch -a
 * master
 * remotes/origin/HEAD -> origin/master
 * remotes/origin/feature
 * remotes/origin/master
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git checkout -b feature
 * origin/feature
 * branch 'feature' set up to track 'origin/feature'.
 * Switched to a new branch 'feature'
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git branch -a
 * feature
 * master
 * remotes/origin/HEAD -> origin/master
 * remotes/origin/feature
 * remotes/origin/master
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git checkout master
 * Switched to branch 'master'
 * Your branch is up to date with 'origin/master'.
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git status
 * On branch master
 * Your branch is up to date with 'origin/master'.
 * 
 * nothing to commit, working tree clean
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git merge feature
 * Auto-merging HelloWorld.java
 * CONFLICT (content): Merge conflict in HelloWorld.java
 * Automatic merge failed; fix conflicts and then commit the result.
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ code .
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ cat HelloWorld.java
 * public final class HelloWorld {
 * 
 * private static final String AUTHOR = "Danilo Pianini";
 * 
 * public static void main(final String[] args) {
 * System.out.println("This program has been realised by " + AUTHOR);
 * System.out.println("This program is running in a PC with " + procNumber() +
 * " logic processors!");
 * }
 * 
 * public static int procNumber() {
 * return Runtime.getRuntime().availableProcessors();
 * }
 * 
 * }
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git add .
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git commit -m
 * "Resolved conflict"
 * [master 7f1d1bf] Resolved conflict
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git status
 * On branch master
 * Your branch is ahead of 'origin/master' by 2 commits.
 * (use "git push" to publish your local commits)
 * 
 * nothing to commit, working tree clean
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git branch
 * feature
 * master
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git remote add myremote
 * git@github.com:Elettraa/lab06-61-merge-conflict-OOP.git
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git remote -v
 * myremote git@github.com:Elettraa/lab06-61-merge-conflict-OOP.git (fetch)
 * myremote git@github.com:Elettraa/lab06-61-merge-conflict-OOP.git (push)
 * origin git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
 * origin git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (push)
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git push myremote master
 * Enumerating objects: 15, done.
 * Counting objects: 100% (15/15), done.
 * Delta compression using up to 16 threads
 * Compressing objects: 100% (11/11), done.
 * Writing objects: 100% (15/15), 1.55 KiB | 1.55 MiB/s, done.
 * Total 15 (delta 4), reused 10 (delta 2), pack-reused 0
 * remote: Resolving deltas: 100% (4/4), done.
 * To github.com:Elettraa/lab06-61-merge-conflict-OOP.git
 * [new branch] master -> master
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git branch
 * --set-upstream-to=myremote/master
 * branch 'master' set up to track 'myremote/master'.
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git status
 * On branch master
 * Your branch is up to date with 'myremote/master'.
 * 
 * nothing to commit, working tree clean
 * elettra@MioPC:~/OOP-git-merge-conflict-test$ git log --graph --oneline
 * 7f1d1bf (HEAD -> master, myremote/master) Resolved conflict
 * |\
 * | * bed943f (origin/feature, feature) Print author information
 * | 8e0f29c (origin/master, origin/HEAD) Change HelloWorld to print the number
 * of available processors
 * |/
 * d956df6 Create .gitignore
 * 700ee0b Create HelloWorld
 */