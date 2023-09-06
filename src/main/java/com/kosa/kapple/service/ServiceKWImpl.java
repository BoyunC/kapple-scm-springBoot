package com.kosa.kapple.service;

import com.kosa.kapple.domain.ContractVO;
import com.kosa.kapple.domain.ProposalVO;
import com.kosa.kapple.domain.SupplierVO;
import com.kosa.kapple.mapper.MapperKW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceKWImpl implements ServiceKW{

    @Autowired
    private MapperKW mapper;
    @Override
    public List<SupplierVO> allSuppl(String compo_name) {
        return mapper.getAll(compo_name);
    }

    @Override
    public ProposalVO getProposal(String compo_name, String suppl_no) {
        return mapper.getProposal(compo_name,suppl_no);
    }

    @Override
    public ProposalVO getProposaltoContract(String proposal_no) {
        return mapper.getProposaltoContract(proposal_no);
    }

    @Override
    @Transactional
    public ContractVO saveContract(ContractVO contract) {
        int num=mapper.lastSEQ();
        contract.setContract_no("CTRT"+num);
        mapper.saveContract(contract);
        String proposal_no=contract.getProposal_no();
        mapper.upProposalStat(proposal_no);
        return contract;
    }
}
