[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=7661714&assignment_repo_type=AssignmentRepo)
Compsci 677: Distributed and Operating Systems

Spring 2022

# Homework 6: Hardware Virtualization and Cloud Computing

The purpose of this homework is to provide hands-on experience with hardware virtualization and
cloud computing.

## Part 1: Hardware Virtualization with VirtualBox

For hardware virtualization we will be using VirtualBox, which does binary translation to run
unmodified operating systems as virtual machines. You can download VirtualBox for your platform
[here](https://www.virtualbox.org/wiki/Downloads).

> Note for Mac with Intel processors: After installation you might get an error saying "The
> Installation Failed". This is due to the installer was blocked by the Mac OS X "Security &
> Privacy" settings. You can follow the steps described
> [here](https://medium.com/@DMeechan/fixing-the-installation-failed-virtualbox-error-on-mac-high-sierra-7c421362b5b5)
> to resolve this issue.

> Note for Mac with M1 processors: VirtualBox does not support ARM architecture like the Apple M1
> processors. For students who want to do this homework on an Apple machine with M1 processors you
> can use the Parallels Desktop for Mac instead. It offers a 14 day trial and you can install it
> from [here](https://www.parallels.com/products/desktop/welcome-trial/)

### Installing an OS on a new VM

We will use an `.iso` image to install an operating system onto a _virtual disk_, just as you would
install an OS onto an actual physical hard disk. We will use Ubuntu as the operating system
(although you can install any OS of your choice). You can download the image of Ubuntu 18.04 here:

* desktop image: http://releases.ubuntu.com/bionic/ubuntu-18.04.6-desktop-amd64.iso
* server image: http://releases.ubuntu.com/bionic/ubuntu-18.04.6-live-server-amd64.iso

Create a new VM by clicking on the "New" button. Give your VM a name, for example "ubuntu-vm". You
can change the local of VM if you want. In the "type" dropdown menu select "Linux", and in the
"Version" dropdown menu select "Ubuntu (64-bit)".

#### Memory

The next step is to allocate hardware resources for your VM. VirtualBox will ask the amount of
memory to be allocated to the virtual machine. The memory here depends on which image you choose: if
you are installing the desktop image we recommend allocating at least 2GB since it will run a
desktop environment (GNOME) which can use a fair amount of memory. It also depends on how much
physical RAM is available on your host machine since the memory allocated to the VM cannot be used
by other programs. If you system is memory constrained, consider using the server image which should
be able to run with 1GB of memory.

#### Disk

A virtual machine needs a virtual disk, and you can use a file as a virtual hard drive. In the next
step VirtualBox will ask you to either create a new virtual hard disk file or use an existing
virtual disk file. Here we will select "Create a new virtual hard disk now". Choose the default VDI
format for our virtual hard disk file, then select "dynamically allocated". Finally pick a location
for the virtual hard disk file and specify the disk size. 10GB should suffice.

After creating the virtual hard disk file, note the location of the file that you have created. Say
you created the virtual disk in /home/user/vbox/vdisk1.vdi. What is the size of vdisk1.vdi?

#### Mount the ISO

So far, we’ve allocated storage and memory and thus created a “blank” virtual machine. Now select
the newly created VM on the left side panel, then click the "Start" button. VirtualBox will ask you
to select a virtual optical disk file as the installation media. Select the ISO file we downloaded
earlier (choose a virtual optical disk file -- Add -- pick the ISO file -- Open -- Choose -- Start).

#### Install Ubuntu

The Ubuntu installer screen should appear since the VM boots from the CD-Drive first. Install Ubuntu
as you generally would. You can also refer to this [installation
guide](https://ubuntu.com/tutorials/install-ubuntu-desktop-1804#1-overview) if necessary.

### Post Install

Once the OS is installed, Shut Down the VM or Reboot it. If the installer screen pops up again, the
VM is still booting from the CD and not from the hard-disk. Remove the CD-Drive from the settings if
the OS was installed successfully. This should now cause the hypervisor to pick the hard-disk to
boot from instead of the CD.

Try logging in and running your favorite programs. Try Pausing/UnPausing your VM. What is the
difference between power-cycling the VM and pausing/resuming?

> Note: If you change the VM settings, you will need to restart the VM to apply the changes.

#### Network Access

So far, we have not configured any network interface for the VM. If you need network access for your
VM, ensure that the Network Adapter is enabled in the VM settings. It can be of a NAT or a Bridged
type. Try both and report which works on your system.

Look up the IP address of your host system and the IP address of the VM. What are the IPs?

#### CPU

Change the processor configuration in the System tab. You can change the number of CPUs exposed to
the VM, and also enable/disable hardware virtualization acceleration if your CPU provides it
(VT-x/SVM). Look carefully through the configuration options for your virtual machine, especially
memory options, CPU options, networking and peripherals.

Write down your observations about configuration options as well as virtual disks.

## Part 2: Cloud Computing with AWS

In this part you will get hands-on experience with AWS Elastic Compute Cloud (EC2, which is the IaaS
offering for AWS). You will learn how to configure AWS CLI, how to create an EC2 instance, how to
connect to an EC2 instance, how to clean up EC2 resources, etc. **Please take note of the time you
spend in every operation because at the end of this part you need to estimate the cost of all the
operations in this AWS homework**.

> Note: For students using Windows, please run all the commands in this homework in Git Bash.

### Install AWS CLI

AWS CLI is a command line interface for managing AWS services including EC2. It supports all major
platforms (Linux, macOS, and Windows). You can follow the instructions
[here](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html) to install AWS
CLI on your machine. To verify your installation, open a terminal and run `aws --version`. The
output should start with something like `aws-cli/2.5.6`. If the `aws` command cannot be found, you
may need to restart your terminal or follow the instructions
[here](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-path.html) to add the AWS
CLI to your `PATH`.

### Obtain AWS Credentials

We will be adding all the students to a class on AWS Academy, and each student will get their own
credentials through AWS Academy. You should soon receive a course invitation email from AWS Academy
that looks like this:

![Course Invitation](images/course_invitation.png)

Click "Get Started" and follow the instructions to create a Canvas Account. If you already have a
Canvas account (e.g., if you have used AWS Academy in another class) you should login using your
existing account.

After logging in to your account, click "Modules" then "Learner Lab - Foundational Services".

![Modules](images/modules.png)

Now you will be greeted with the terms and conditions, read them if you want then click "I agree".
Now you should see the following page. Click the "Start Lab" button. It may take several minutes to
start the AWS environment.

![Start Lab](images/start_lab.png)

> Note: A lab session is limited to 4 hours so please plan your time ahead.

After the lab has been started, click the "AWS Details" button. On the right side panel there will
be a "Show" button following AWS CLI, click on that. The code that appeared in the textbox below
contains the credentials that the AWS CLI uses to interact with AWS. Copy the code and save it to
`$HOME/.aws/credentials` on Linux/macOS or `%USERPROFILE%/.aws/credentials` (The value of
`%USERPROFILE%` usually is `c:\Users\username`) on Windows.

![Credentials](images/credentials.png)

> Note: Every time you start the lab AWS Academy will generate new credentials for you. Therefore if
> you end a lab and then start a new lab, you should delete you previous credentials file and create
> a new one using your new credentials.

There will also be a "Download PEM" button following SSH key, click on that. Save the PEM key file
to your working directory.

### Configure Your AWS Settings

Next we need to configure and the default AWS Region where AWS resources (including EC2 instances)
will be deployed, and the default output format of AWS CLI commands. and run `aws configure`, then
follow the steps below:

1. It will ask your AWS Access Key ID, we have already configured that in the previous step by
   creating a credentials file. Just press enter to skip this step.
2. It will ask your AWS Secret Access Key, we have also configured that in the previous step. Press
   enter to skip this step.
3. For default region name, be sure to input `us-east-1`. Otherwise the PEM key we just downloaded
   won't work!
4. For default output format, input `json`.

If you made a mistake in step 1 or 2, go back to the AWS Academy webpage, copy the credentials and
save it to `$HOME/.aws/credentials` on Linux/macOS or `%USERPROFILE%/.aws/credentials` on Windows.
If you made a mistake in step 3 or 4, just run `aws configure` again and input the correct value.

### Start Your First EC2 Instance

When creating an EC2 instance, two of the most important settings to consider are 1) what instance
type to use (this determines how much resources are allocated to your instance, as well as cost you
will be paying), and 2) what image to use (this determines what operating system will running inside
your instance).

Here we will use the `t2.micro` instance type as it is one of the cheapest instance types available
on AWS. For image id we will be using the Ubuntu 18.04 server image provided by Canonical, at the
time of writing the latest AMI (Amazon Machine Images) ID is `ami-0d73480446600f555`. If you are
curious, you can also find the AMD IDs of other Ubuntu versions here:
https://cloud-images.ubuntu.com/locator/ec2/ (be sure to select the correct region and arch).

Now we can create our first EC2 instance using AWS CLI. Open a terminal and run

```shell
aws ec2 run-instances --image-id ami-0d73480446600f555 --instance-type t2.micro --key-name vockey > instance.json
```

The `instance.json` file will contain the details of your instance. Copy the `InstanceId` field. Now
in your terminal check the status of your instance using the following command:

```shell
aws ec2 describe-instances --instance-id <your-instance-id>
```

This gives various details about the instance type, who is running it, and the public DNS name where
you can access the instance, something like

```
ec2-54-85-216-54.compute-1.amazonaws.com
```

Record the approximate time it took to create the instance (seconds? minutes?)

### Access Your EC2 instance via SSH

Before running ssh command there are two things we need to do. The first is to set the right
permission for the PEM key.

```shell
chmod 400 labuser.pem
```

The other thing we need to do is to authorize port 22 (used by ssh) in the default security group
(you can think of security group as a virtual firewall).

```shell
# allows ssh access from anywhere
aws ec2 authorize-security-group-ingress --group-name default --protocol tcp --port 22 --cidr 0.0.0.0/0
```

> Note: If you get an `InvalidPermission.Duplicate` error that means ssh has already been enabled in
> your security group. You can simply ignore this error

Now that everything is ready, we can connect to our instance via ssh:

```shell
ssh -i labsuser.pem ubuntu@<your-instance's-public-DNS-name>
```

ssh may ask you about the instance key fingerprint, if so just input yes. Now you should get a shell
to your EC2 instance and your can manage your instance from there.

### Install Softwares

You can instal softwares on EC2 instances just like on any other linux machines:

```shell
sudo apt update && sudo apt install -y emacs
```

### Create a New Image from a Running Instance

Now we can take our customized server and create a new machine image based on its disk state. This
will allow us to create a new future instance with these customized applications preinstalled.

On your local terminal, use the `create-image` command and give it the instance-id and a name for
your new image.

```shell
aws ec2 create-image --instance-id <your-instance-id> --name 677_test_image
```

If successful, this returns a new AMI, note down this ami-id. Check if the AMI has been registered:

```shell
aws ec2 describe-images --image-ids <your-new-ami-id>
```

### Create an Instance Using This New Image

You can now terminate your old instance since we have already created a machine image with our
changes.

```shell
aws ec2 terminate-instances --instance-ids <your-instance-id>
```

You can approximate the time it takes to terminate by looking at the output and see the status of
your instance (running/shutting-down/stopped/terminated, etc). Now you can start another instance
from your customized AMI!

```shell
aws ec2 run-instances --image-id <your-new-ami-id> --instance-type t2.micro --key-name vockey > instance.json
```

Note that the instance id of this newly created instance is different. You can ssh into this new
instance to verify that emacs has already been installed. After that terminate the instance using
the `ec2-terminate-instances` command as before.

### Estimate the Cost of All Operations in This AWS homework

Use [Amazon’s pricing policy](https://aws.amazon.com/ec2/pricing/) to compute the cost of all
operations you performed in this assignment. Note which instances you used and for how much time.
Then search how much they cost per unit of time (On Demand pricing) and estimate how much you have
spent in total. Factor in storage costs: unless your instance has local storage, its filesystem will
be stored by an external storage system (EBS) that incurs a cost even if the instance is off. Then
consider other costs such as out of network data transfers, S3 operations, etc.

### Cleaning up

Be sure to terminate your instances. Note that Amazon gives each student a certain amount of credits
and if you do not terminate your cloud servers, they will continue to incur usage changes and use up
your entire usage limit.

You also need to deregister you newly created AMI by

```shell
aws ec2 deregister-image --image-id <your-ne-ami-id>
```

Deregistering an AMI does not actually delete it, you need to delete the snapshot associated with
the AMI. First find the snapshot by

```shell
aws ec2 describe-snapshots --owner-ids self
```

Note down the snapshot ID from the command output, then you can delete the snapshot using

```shell
aws ec2 delete-snapshot --snapshot-id <your-snapshot-id>
```

Finally, go back to the AWS Academy webpage and click the "End Lab" button to end you lab session.


## What to submit

Please turn in a short (1-2 page) report with your observations and output from the key steps in
this assignment. Please include the following information.

Answer all the questions listed in the description of the steps.

* Part 1

  * What is the size of the virtual disk on the host? Run `df` in the VM and report the size of the
    file-system that the VM sees.
  * How long (approximately) does it take to pause and unpause a running VM?
  * Which networking option (NAT/Bridged) worked for you? What are the IP addresses of your host and
    your VM?
  * How much RAM and disk space did you allocate to the VM?
  * What configuration options did you examine for the VM?

* Part 2

  * How long did it take to create an EC2 instance?
  * Provide an estimate (approximate estimates are OK) on how much your EC2 operations will cost.
    Use Amazon’s pricing policy and monitoring data to compute your estimates.
  * Clearly mention which EC2 api commands you tried, and All the AMI and instance IDs that you
    created.
