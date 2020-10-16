package mk.gov.moepp.emi.invertoryinfo.service.impl;

import mk.gov.moepp.emi.invertoryinfo.exception.ResourceNotFound;
import mk.gov.moepp.emi.invertoryinfo.model.Gas;
import mk.gov.moepp.emi.invertoryinfo.model.dto.GasDto;
import mk.gov.moepp.emi.invertoryinfo.repository.GasRepository;
import mk.gov.moepp.emi.invertoryinfo.service.GasService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GasServiceImpl implements GasService {

    private final GasRepository gasRepository;

    public GasServiceImpl(GasRepository gasRepository) {
        this.gasRepository = gasRepository;
    }

    @Override
    public List<Gas> getAllGasses() {
        return gasRepository.findAll();
    }

    @Override
    public Gas getGas(int id) {
        return gasRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Gas saveGas(Gas gas) {
        return gasRepository.save(gas);
    }

    @Override
    public Gas editGas(int id, GasDto gasDto) {
        Gas gas = gasRepository.findById(id).orElse(new Gas());
        gas.setName(gasDto.getName());
        return gasRepository.save(gas);
    }

    @Override
    public void deleteGas(int id) {
        gasRepository.deleteById(id);
    }

    @Override
    public Gas findByNameEquals(String name) {
        return gasRepository.findByNameEquals(name);
    }
}
