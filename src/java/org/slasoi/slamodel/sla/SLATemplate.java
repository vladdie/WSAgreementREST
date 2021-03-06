/* 
SVN FILE: $Id: $ 
 
Copyright (c) 2008-2010, Engineering Ingegneria Informatica S.p.A.
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of Engineering Ingegneria Informatica S.p.A. nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Engineering Ingegneria Informatica S.p.A. BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

@author         $Author: $
@version        $Rev: $
@lastrevision   $Date: $
@filesource     $URL: $

*/

package org.slasoi.slamodel.sla;

import org.slasoi.slamodel.primitives.ID;
import org.slasoi.slamodel.primitives.UUID;
import org.slasoi.slamodel.vocab.bnf;

import org.slasoi.slamodel.core.Annotated;

public class SLATemplate extends Annotated{
	
	private static final long serialVersionUID = 1L;

	public static final String $model_version = "sla_at_soi_sla_model_v1.0";
	
	protected UUID _uuid = null;
	private Party[] _parties = null;
	private InterfaceDeclr[] _ifaces = null;
	private VariableDeclr[] _vars = null;
	private AgreementTerm[] _terms = null;
	
	public void setUuid(UUID uuid){ _uuid = uuid; }
	
	public UUID getUuid(){ return _uuid; }
	
	public String getModelVersion(){ return $model_version; }
	
	public void setParties(Party[] parties){ _parties = parties; }
	
	public Party[] getParties(){ return _parties; }
    
    /**
     * Retrieves the Party with the given id
     * @param id
     * @return
     */
	public Party getParty(String id){
        if (id != null && _parties != null){
            for (Party p : _parties){
                if (p.getId().getValue().equals(id)) return p;
            }
        }
        return null;
    }
	
    /**
     * Retrieves the Party.Operative with the given id (which must be a path-identifier)
     * @param id
     * @return
     */
	public Party.Operative getPartyOperative(String id){
        if (id != null){
            String[] ss = id.split(ID.$path_separator);
            if (ss.length==2){
                Party p = getParty(ss[0]);
                if (p != null) return p.getOperative(ss[1]);
            }
        }
        return null;
    }
	
	public void setInterfaceDeclrs(InterfaceDeclr[] ifaces){ _ifaces = ifaces; }
	
	public InterfaceDeclr[] getInterfaceDeclrs(){ return _ifaces; }
    
    /**
     * Retrieves the InterfaceDeclr with the given id
     * @param id
     * @return
     */
	public InterfaceDeclr getInterfaceDeclr(String id){
        if (id != null && _ifaces != null){
            for (InterfaceDeclr w : _ifaces){
                if (w.getId().getValue().equals(id)) return w;
            }
        }
        return null;
    }
	
	public void setVariableDeclrs(VariableDeclr[] vars){ _vars = vars; }
	
	public VariableDeclr[] getVariableDeclrs(){ return _vars; }
	
	/**
	 * Retrieves the VariableDeclr for the given variable name 
	 * (also accepts path-identifiers for variables which are embedded inside AgreementTerms).
	 * @param variableName
	 * @return
	 */
	public VariableDeclr getVariableDeclr(String variableName){
	    if (variableName != null){
	        String[] ss = variableName.split(ID.$path_separator);
	        if (ss.length == 1){
	            if (_vars != null) for (VariableDeclr v : _vars){
	                if (v.getVar().getValue().equals(variableName)) return v;
	            }
	        }else if (ss.length == 2){
	            AgreementTerm t = getAgreementTerm(ss[0]);
	            if (t != null) return t.getVariableDeclr(ss[1]);
	        }
	    }
	    return null;
	}
	
	public void setAgreementTerms(AgreementTerm[] terms){ _terms = terms; }
	
	public AgreementTerm[] getAgreementTerms(){ return _terms; }
    
    /**
     * Retrieves the AgreementTerm with the given id
     * @param id
     * @return
     */
	public AgreementTerm getAgreementTerm(String id){
        if (id != null && _terms != null){
            for (AgreementTerm t : _terms){
                if (t.getId().getValue().equals(id)) return t;
            }
        }
        return null;
    }
    
    /**
     * Retrieves the Guaranteed State or Action with the given id (which must be a path-identifier)
     * @param id
     * @return
     */
    public Guaranteed getGuaranteed(String id){
        if (id != null){
            String[] ss = id.split(ID.$path_separator);
            if (ss.length==2){
                AgreementTerm t = getAgreementTerm(ss[0]);
                if (t != null) return t.getGuaranteed(ss[1]);
            }
        }
        return null;
    }
	
	public String toString(){ return bnf.render(this, false); }

}
