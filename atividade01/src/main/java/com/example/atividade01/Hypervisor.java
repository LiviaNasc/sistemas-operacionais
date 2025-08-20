package com.example.atividade01;

import java.util.ArrayList;
import java.util.List;

public class Hypervisor {
    private List<VirtualMachine> vms;

    public Hypervisor() {
        this.vms = new ArrayList<>();
    }

    public void addVM(VirtualMachine vm) {
        vms.add(vm);
    }

    public List<VirtualMachine> getVMs() {
        return vms;
    }
}
