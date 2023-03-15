package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.RedSocial;
import java.util.List;

public interface IRedSocialService {
    
    public List<RedSocial> getRedes();
    
    public void saveRed(RedSocial red);
    
    public void deleteRed(Long id);
    
    public RedSocial findRed(Long id);
    
    public void editRed(RedSocial red);
    
    public void editRed(Long idRed, RedSocial redMod);
}
