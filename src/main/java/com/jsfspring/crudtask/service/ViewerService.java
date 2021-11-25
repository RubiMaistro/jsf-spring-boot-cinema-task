
package com.jsfspring.crudtask.service;

import java.util.List;

import com.jsfspring.crudtask.uito.ViewerUITO;

public interface ViewerService {
	ViewerUITO doSaveViewer(ViewerUITO viewerUiTO);

	List<ViewerUITO> doFetchAllViewer();

	ViewerUITO doGetViewer(ViewerUITO viewerUiTO);

	void doDeleteViewer(ViewerUITO viewerUiTO);
}