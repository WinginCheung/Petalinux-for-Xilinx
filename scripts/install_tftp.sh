# install_tftp.sh
#!/bin/bash
configfile="/etc/default/tftpd-hpa"
sudo apt install -y tftpd-hpa tftp-hpa
sudo cp ${configfile} /etc/default/tftpd-hpa.bck
sudo sed -i '/^TFTP_OPTION/d' ${configfile}
sudo sed -i '$a TFTP_OPTION=\"--secure --create\"' ${configfile}
sudo chown -R tftp /var/lib/tftpboot/
echo "export TFTP_DIRECTORY=\`cat /etc/default/tftpd-hpa | grep TFTP_DIRECTORY | cut -d \"\\\"\" -f 2\`" | sudo tee -a /etc/bash.bashrc >/dev/null
sudo systemctl enable tftpd-hpa
sudo systemctl restart tftpd-hpa
