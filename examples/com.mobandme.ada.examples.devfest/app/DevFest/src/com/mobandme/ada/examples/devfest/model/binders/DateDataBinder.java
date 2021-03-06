/**
   Copyright Mob&Me 2013 (@MobAndMe)

   Licensed under the GPL General Public License, Version 3.0 (the "License"),  
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.gnu.org/licenses/gpl.html

   Unless required by applicable law or agreed to in writing, software 
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
   Website: http://adaframework.com
   Contact: Txus Ballesteros <txus.ballesteros@mobandme.com>
*/

package com.mobandme.ada.examples.devfest.model.binders;

import java.util.Date;

import android.view.View;

import com.mobandme.ada.DataBinder;
import com.mobandme.ada.DataBinding;
import com.mobandme.ada.Entity;
import com.mobandme.ada.examples.devfest.helpers.ExceptionsHelper;
import com.mobandme.ada.examples.devfest.model.entities.Employee;
import com.mobandme.ada.exceptions.AdaFrameworkException;

public class DateDataBinder extends DataBinder {

	@Override
	public void bind(DataBinding pBinding, Entity pEntity, View pView, int pDirection) throws AdaFrameworkException {
		try {
			
			if (pDirection == DataBinder.BINDING_UI_TO_ENTITY) {
				Date dateValue = (Date)pView.getTag();
				((Employee)pEntity).setDateOfBirth(dateValue);
			} else {
				if (pView != null) {
					pView.setTag(((Employee)pEntity).getDateOfBirth());
					super.bind(pBinding, pEntity, pView, pDirection);
				}
			}
			
		} catch (Exception e) {
			ExceptionsHelper.manage(pView.getContext(), e);
		}
	}
}
