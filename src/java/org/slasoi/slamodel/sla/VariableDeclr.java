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
import org.slasoi.slamodel.primitives.Expr;
import org.slasoi.slamodel.vocab.bnf;
import org.slasoi.slamodel.vocab.meta;
import org.slasoi.slamodel.vocab.ext.Entity;
import org.slasoi.slamodel.core.Annotated;
import org.slasoi.slamodel.core.CID;
import org.slasoi.slamodel.core.ConstraintExpr;

public class VariableDeclr extends Annotated implements Entity.Instance{
	
	private static final long serialVersionUID = 1L;
	
    protected ID _v = null;
	protected Expr _expr = null;
    
    public Entity entity(){ return meta.VARIABLE; }
	
	/**
     * @deprecated
     */
    public VariableDeclr(){}
    
    public VariableDeclr(ID v, Expr e){
        setVar(v);
        setExpr(e);
    }
	
	public void setVar(ID v){
        if (v == null) throw new IllegalArgumentException("No variable ID/name specified");
        if ((_expr instanceof ConstraintExpr) && !(v instanceof CID)) v = new CID(v.getValue());
        _v = v;
	}
	
	public ID getVar(){ return _v; }
	
	public void setExpr(Expr e){
        if (e == null) throw new IllegalArgumentException("No Expr specified");
	    _expr = e;
	    setVar(_v);
	}
	
	public Expr getExpr(){ return _expr; }
    
    public String toString(){
        return bnf.render(this); 
    }

}
