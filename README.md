# Getting Started

## Team 13

- Wesley Hataway
- Eric Latham
- Hardik Patel
- Tahseen Robbani
- Daniel Swinney

### Sign into GitLab

- Sign into [the UAB CS department's GitLab](https://gitlab.cs.uab.edu/) with your BlazerID and password

### Make Your GitLab Email Public

This will be helpful later on when we set up [Clubhouse](#clubhouse)

- Go to your user settings in the top right corner of the screen
- Under "Public email", select your UAB email address
- Scroll down and click "Update profile settings"

### Set Up GitLab SSH Key

- Go [here](https://gitlab.cs.uab.edu/profile/keys) to add a new SSH key pairing between your GitLab account and your personal computer
  - This will allow you use GitLab repositories on your computer without entering your GitLab password all the time
- For instructions on creating the SSH key pair on your computer, look [here](https://gitlab.com/help/ssh/README#generating-a-new-ssh-key-pair)
  - Open a terminal
  - Enter `ssh-keygen -t rsa -b 4096` in the terminal and press enter through the prompts
  - Enter `cat ~/.ssh/id_rsa.pub` to print out the PUBLIC key
  - Copy and paste the PUBLIC key into the "Add an SSH key" text box, give it a title, and click "Add key"

### Clone Project Repository

- In the terminal, create a CS420 folder wherever you want the project files to be stored
  - For example, enter `mkdir CS420` in the directory where you want the new directory to live
- `cd` into the CS420 directory you made
  - For example, enter `cd CS420`
- Enter `git clone git@gitlab.cs.uab.edu:420/project2.git`
  - The URL `git@gitlab.cs.uab.edu:420/project2.git` can also be found and copied from the "Clone" -> "Clone with SSH" button on the [repository page](https://gitlab.cs.uab.edu/420/project2)
  - If `git` is not installed, you will need to install `git` first
- `cd` into the cloned project 2 repository
  - Enter `cd project2`

### Using Git

The following are commands you will enter into your terminal while inside the `project2` directory

#### `git pull`

*Download changes from other users*

#### `git add <new or edited file in repo>`

*Add your own local changes to be committed to the repo*

- Example: `git add report.md`

#### `git commit -m "<commit message explaining what you added/changed>"`

*Declare your changes before uploading them*

- Example: `git commit -m "Write the project2 report"`

#### `git push`

*Upload your committed changes*

### Using Visual Studio Code and Markdown

- To install Visual Studio Code, look [here](https://code.visualstudio.com/Download)
- For info on using Markdown in Visual Studio Code, look [here](https://code.visualstudio.com/docs/languages/markdown)
- Install the following plug-ins in Visual Studio Code:
  - `DavidAnson.vscode-markdownlint`
  - `yzane.markdown-pdf`

### Clubhouse

Clubhouse is a great product for tracking agile software development projects like ours

- Go [here](https://app.clubhouse.io/invite-link/5f5bf76f-ac0f-42d1-ae4d-c85cfe8c9427) and sign up (you can sign up with your Google account)
- Explore the "Epics" and "Stories" already written in the team workspace
- We will use Clubhouse to assign, document, track, and collaborate on tasks throughout the project lifecycle

### Additional Resources

#### LucidChart

We will use this for making diagrams and prototypes

#### Eclipse

We will use this for writing Java/JavaFX code.

#### SceneBuilder

We will use this for creating FXML documents to integrate with our Java/JavaFX code.
