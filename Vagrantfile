# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.define "parity" do |parity|
    parity.vm.box = "ubuntu/trusty64"
  end

  config.vm.provider "virtualbox" do |v|
    v.memory = 2048
  end

  config.vm.network "forwarded_port", guest: 8545, host: 8545

  config.vm.provision "shell", name: "install parity", inline: <<-SHELL
    NAME=parity
    VERSION=1.5.2
    DEB=${NAME}_${VERSION}_amd64.deb
    URL=http://d1h4xl4cr1h0mo.cloudfront.net/v${VERSION}/x86_64-unknown-linux-gnu/${DEB}

    if dpkg-query -W parity 2>/dev/null | grep ${VERSION}; then
      echo "${NAME} already installed."
    else
      echo "wget -q ${URL}"
      wget -q ${URL}
      dpkg -i ${DEB}
      ln -s /vagrant/${NAME} /etc/${NAME}
      cp /vagrant/${NAME}/init /etc/init.d/${NAME}
      update-rc.d ${NAME} defaults
    fi
  SHELL

  config.vm.provision "shell", name: "restart parity" do |s|
    s.env = {"CONFIG": ENV['CONFIG'], "CHAIN": ENV['CHAIN']}
    s.inline = <<-SHELL
        export CONFIG=${CONFIG-:default} CHAIN=${CHAIN-:default} ; /etc/init.d/parity restart
    SHELL
  end
end