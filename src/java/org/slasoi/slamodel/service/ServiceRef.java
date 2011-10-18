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

package org.slasoi.slamodel.service;

import org.slasoi.slamodel.primitives.ID;
import org.slasoi.slamodel.primitives.ValueExpr;
import org.slasoi.slamodel.vocab.bnf;
import org.slasoi.slamodel.vocab.meta;
import org.slasoi.slamodel.vocab.ext.Entity;

public class ServiceRef implements ValueExpr, Entity.Instance{
	
	private static final long serialVersionUID = 1L;

	private ID[] _interfaceIds = null;
	private ID[] _operationIds = null;
	private ID[] _endpointIds = null;
        
    public Entity entity(){ return meta.SERVICE; }
    
    public ServiceRef(){}
	
	public ServiceRef(ID[] interfaceDeclrIds, ID[] operationIds, ID[] endpointIds){
	    setInterfaceDeclrIds(interfaceDeclrIds);
	    setOperationIds(operationIds);
	    setEndpointIds(endpointIds);
	}
	
	public void setInterfaceDeclrIds(ID[] ids){ _interfaceIds = ids; }
	
	public ID[] getInterfaceDeclrIds(){ return _interfaceIds; }
	
	public void setOperationIds(ID[] ids){ _operationIds = ids; }
	
	public ID[] getOperationIds(){ return _operationIds; }
	
	public void setEndpointIds(ID[] ids){ _endpointIds = ids; }
	
	public ID[] getEndpointIds(){ return _endpointIds; }
	
    public String toString(){ return bnf.render(this); }

}
